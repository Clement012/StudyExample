import pandas as pd
import requests
import logging
from bs4 import BeautifulSoup

# Configure logging
# logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
bibIDs = ['NPTCM19040630','NPTCM19270627','NPTCM19230119','NPTCM19100517']
oldURLs = ['QF757YsWv5%2BakvA8rFW5EsSOFS5qV6UJ','QF757YsWv59H%2FuxqfBwEJG%2F9zi7scYYM','QF757YsWv59H%2FuxqfBwEJL3lHxvvvGKb','QF757YsWv5%2BakvA8rFW5EmtB5NubYDyd']

SUBSYSTEM_ID = '1522476933491560449'
default_ofa_token = ''
lang = 'en' #tc/sc
langInCookie = 'en_GB' #en_GB/ zh_TW
all_data = []

def login(bibID):
    url = 'https://202.40.137.102/api/ofa-admin/login'
    headers = {
        'Content-Type': 'application/json; charset=utf-8',
        'SUBSYSTEM-ID': SUBSYSTEM_ID
    }
    data = {
        'username': 'clementyau',
        'password': 'IIkNxDIBl78goGTEFvc+yA=='
    }

    # logging.info('Attempting to log in with bibID: %s', bibID)

    try:
        response = requests.post(url, headers=headers, json=data, verify=False)
        response.raise_for_status()
        result = response.json()
        default_ofa_token = result.get('data', {}).get('ofa_token')
        # logging.info('Login successful, obtained token: %s', default_ofa_token)
        ajax = get_search_results(default_ofa_token, bibID)
    except requests.exceptions.RequestException as e:
        logging.error('%s 錯誤: %s', url, e)

def get_search_results(default_ofa_token, bibID):
    url = f'https://202.40.137.102/api/drmapi/admin/catalogueRecord/esCatalogue/search?searchModel=2&catalogueNo={bibID}&current=1&size=30'
    headers = {
        'OFA-TOKEN': default_ofa_token
    }
    
    # logging.info('Fetching search results for bibID: %s', bibID)
    
    try:
        response = requests.get(url, headers=headers, verify=False)
        response.raise_for_status()
        result = response.json()
        
        # Process the result
        records = result.get('data', {}).get('records', [])
        filtered_data = [{
            'BibID': bibID,
            'OldURL': oldURL,
            'NewURL': record.get('encryptId'),
            'ItemNo': record.get('itemNo')
        } for record in records if record.get('catalogueNo') == bibID]

        all_data.extend(filtered_data)
        
    except requests.exceptions.RequestException as e:
        logging.error('Error fetching search results: %s', e)

for bibID, oldURL in zip(bibIDs, oldURLs):
    login(bibID)

df = pd.DataFrame(all_data)
# df.to_excel('output2.xlsx', index=False) #CHANGE LOGIC on .xlsx

###

# def getOldLocations(oldURL, langInCookie):
#     # Clear existing cookies
#     session = requests.Session()
#     session.cookies.clear()

#     # Set cookies
#     session.cookies.set('GUEST_LANGUAGE_ID', langInCookie)
#     session.cookies.set('localeCookie', langInCookie)
#     session.cookies.set('PORTAL_LANGUAGE_SET', 'Y')

#     # Call the API
#     old_locations = getOldLocationsAPI(session, oldURL)
#     return old_locations

# def getOldLocationsAPI(session, oldURL):
#     url = f'https://mmis.hkpl.gov.hk/-/coverpage/view?p_r_p_-1078056564_c={oldURL}&_coverpage_WAR_mmisportalportlet_log=Y&tabs1=ACCESSIBLE_LOCATION'
    
#     try:
#         response = session.get(url)
#         print(url)
#         response.raise_for_status()  # Check if the request was successful
#         print(f"Success: {response.status_code}")
#         return response.json()
#     except requests.exceptions.HTTPError as http_err:
#         print(f"HTTP error occurred: {http_err}")
#     except Exception as err:
#         print(f"Other error occurred: {err}")
#     return None

# for oldURL in oldURLs:
#     old_locations = getOldLocations(oldURL, langInCookie)
#     print(old_locations)

def getOldLocations(oldURL, langInCookie, session=None):
    
    # Create a new session if one is not provided
    if session is None:
        session = requests.Session()

    # Set cookies directly
    session.cookies.set('GUEST_LANGUAGE_ID', langInCookie)
    session.cookies.set('localeCookie', langInCookie)
    session.cookies.set('PORTAL_LANGUAGE_SET', 'Y')

    # Call the API
    return getOldLocationsAPI(session, oldURL)

def getOldLocationsAPI(session, oldURL):
    # Build the complete URL
    url = f'https://mmis.hkpl.gov.hk/-/coverpage/view?p_r_p_-1078056564_c={oldURL}&_coverpage_WAR_mmisportalportlet_log=Y&tabs1=ACCESSIBLE_LOCATION'
    
    try:
        # Make the request
        response = session.get(url)
        response.raise_for_status()  # Raise HTTPError for bad responses (4xx or 5xx)
        print(f"Success: {response.status_code}")  # Log success

        # Debug: Print response headers and content type
        print("Response Headers:", response.headers)
        print("Content-Type:", response.headers.get('Content-Type'))

        # Check if the response contains JSON
        if 'application/json' in response.headers.get('Content-Type', ''):
            try:
                return response.json()  # Parse the JSON response
            except ValueError as json_err:
                print(f"Error parsing JSON: {json_err}")
                print(f"Response content (raw): {response.text[:500]}")  # Print first 500 chars of response
                return None
        else:
            print(f"Unexpected content type: {response.headers.get('Content-Type')}")
            print(f"Response content (raw): {response.text[:500]}")  # Print first 500 chars of response
            return None

    except requests.exceptions.HTTPError as http_err:
        print(f"HTTP error occurred: {http_err}")
    except requests.exceptions.RequestException as req_err:
        print(f"Request error occurred: {req_err}")
    except Exception as err:
        print(f"Unexpected error occurred: {err}")
    
    return None

# Reuse the same session across multiple requests to improve performance
with requests.Session() as session:
    for oldURL in oldURLs:
        old_locations = getOldLocations(oldURL, langInCookie, session)
        print(old_locations)

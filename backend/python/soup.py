import requests
from bs4 import BeautifulSoup
import pandas as pd

# Step 1: Send a request to a webpage
url = 'https://mmis.hkpl.gov.hk/coverpage/-/coverpage/view?p_r_p_-1078056564_c=QF757YsWv5%2FH7zGe%2FKF%2BFHc6K6YxvenD&_coverpage_WAR_mmisportalportlet_ref=LPEC03'
response = requests.get(url)

# Step 2: Parse the content with BeautifulSoup
soup = BeautifulSoup(response.text, 'html.parser')

# Step 3: Find all headings (h1, h2, h3, etc.)
headings = soup.find_all(['h1'])

# Step 4: Extract text from headings
heading_texts = [heading.text.strip() for heading in headings]

# Step 5: Create a DataFrame and save to Excel
df = pd.DataFrame(heading_texts, columns=['Headings'])
df.to_excel('headings2.xlsx', index=False)

print("Headings have been saved to headings.xlsx")
print(heading_texts)

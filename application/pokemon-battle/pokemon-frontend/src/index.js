new Vue({
  el: '#app',
  data: {
    character1Id: '',
    character2Id: '',
    character1: null,
    character2: null,
    character1CurrentHP: 0,
    character2CurrentHP: 0,
    character1ActionPoints: 0,
    character2ActionPoints: 0,
    character1ActionRate: 0,
    character2ActionRate: 0,
    showCharacterBox: false,
    battleLog: '',
    battleFinished: false,
    showInputBox: true,
    actionBarMax: 200,
    mpMax: 100,
  },
  computed: {
    character1HPPercentage() {
      return ((this.character1CurrentHP / this.character1.base.HP) * 100).toFixed(2);
    },
    character2HPPercentage() {
      return ((this.character2CurrentHP / this.character2.base.HP) * 100).toFixed(2);
    },
    // character1MPPercentage() {
    //   return ((this.character1MP / this.mpMax) * 100).toFixed(2);
    // },
    // character2MPPercentage() {
    //   return ((this.character2MP / this.mpMax) * 100).toFixed(2);
    // },
    character1ActionPercentage() {
      return ((this.character1ActionPoints / this.actionBarMax) * 100).toFixed(2);
    },
    character2ActionPercentage() {
      return ((this.character2ActionPoints / this.actionBarMax) * 100).toFixed(2);
    }
  },
  methods: {
    async fetchCharacters() {
      try {
        const response = await fetch('/api');
        const data = await response.json();

        this.character1 = data.find(c => c.id == this.character1Id);
        this.character2 = data.find(c => c.id == this.character2Id);

        if (!this.character1 || !this.character2) {
          alert('Character not found!');
          return;
        }

        this.character1CurrentHP = this.character1.base.HP;
        this.character2CurrentHP = this.character2.base.HP;
        this.character1ActionRate = this.character1.base.Speed;
        this.character2ActionRate = this.character2.base.Speed;
        console.log("1:" + JSON.stringify(this.character1))
        console.log("2:" + JSON.stringify(this.character2))
        this.character1MP = this.character1.base.MP;
        this.character1MP = this.character2.base.MP;

        this.showCharacterBox = false;
        this.battleFinished = false;
        this.battleLog = ''; // Reset the battle log
        this.showRestartBattle = true;

        setTimeout(() => {
          this.showCharacterBox = true;
          this.showInputBox = false;
          this.showRestart = false;
          this.startActionBars();
        }, 2000);

      } catch (error) {
        console.error('Error fetching data:', error);
      }
    },
    getImageUrl(imagePath) {
      return `http://localhost:8081${imagePath}`;
    },
    getIconsUrl(iconsPath){
      return `http://localhost:8081${iconsPath}`;
    },
    startActionBars() {
      const actionInterval = setInterval(() => {
        if (this.battleFinished) {
          clearInterval(actionInterval);
          return;
        }

        this.character1ActionPoints += this.character1ActionRate * 0.2;
        this.character2ActionPoints += this.character2ActionRate * 0.2;

        if (this.character1ActionPoints >= this.actionBarMax) {
          this.attackCharacter2();
          this.character1ActionPoints = 0;
        }

        if (this.character2ActionPoints >= this.actionBarMax) {
          this.attackCharacter1();
          this.character2ActionPoints = 0;
        }

      }, 200);
    },
    attackCharacter1() {
      if (this.battleFinished) return;

      const damageToCharacter1 = this.calculateDamage(this.character2.base.Attack, this.character1.base.Defense);
      this.character1CurrentHP = Math.max(0, this.character1CurrentHP - damageToCharacter1);
      this.battleLog = `${this.character2.name.chinese} attacks! ${this.character1.name.chinese} takes ${damageToCharacter1} damage!\n`;

      if (this.character1CurrentHP === 0) {
        this.battleLog += `${this.character1.name.chinese} has fainted! ${this.character2.name.chinese} wins!\n`;
        this.battleFinished = true;
        return;
      }
    },
    attackCharacter2() {
      if (this.battleFinished) return;

      const damageToCharacter2 = this.calculateDamage(this.character1.base.Attack, this.character2.base.Defense);
      this.character2CurrentHP = Math.max(0, this.character2CurrentHP - damageToCharacter2);
      this.battleLog = `${this.character1.name.chinese} attacks! ${this.character2.name.chinese} takes ${damageToCharacter2} damage!\n`;

      if (this.character2CurrentHP === 0) {
        this.battleLog += `${this.character2.name.chinese} has fainted! ${this.character1.name.chinese} wins!\n`;
        this.battleFinished = true;
        return;
      }
    },
    calculateDamage(attack, defense) {
      return Math.max(1, attack - defense + 10);
    },
  }
});
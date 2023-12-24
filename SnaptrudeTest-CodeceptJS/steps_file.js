// in this file you can append custom step methods to 'I' object

module.exports = function() {
  return actor({
    login: function(email, password) {
     this.amOnPage('/login');
     this.fillField('div#root div:nth-child(1) > input', 'chetan.g.shavanti@gmail.com');
     this.fillField('div#root div:nth-child(2) > input', 'Test@123');
     this.click('Sign In');
    }
  });
}

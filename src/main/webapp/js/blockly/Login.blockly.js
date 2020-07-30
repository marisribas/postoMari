window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Login = window.blockly.js.blockly.Login || {};

/**
 * Login
 */
window.blockly.js.blockly.Login.abrirModalCadastro = function() {
 var item;
  this.cronapi.screen.showModal("modalCadastroUser");
}

/**
 * Login
 */
window.blockly.js.blockly.Login.fecharModalCadastro = function() {
 var item;
  this.cronapi.screen.hideModal("modalCadastroUser");
}

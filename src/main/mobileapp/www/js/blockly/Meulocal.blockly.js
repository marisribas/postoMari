window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Meulocal = window.blockly.js.blockly.Meulocal || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Meulocal.desenharMapa = function() {
 var item, meulocal;
  meulocal = this.cronapi.maps.createLatLngPoint(this.cronapi.screen.getValueOfField("vars.lat"), this.cronapi.screen.getValueOfField("vars.long"));
  this.cronapi.maps.init("map8045", 'roadmap', meulocal, '16', function(sender_item) {
      item = sender_item;
    this.cronapi.maps.createMarker("map8045", 'meulocal', 'Techne Fortaleza', meulocal, '', 'Esse é o endereço da Techne Fortaleza', '');
  }.bind(this));
}

/**
 * Meulocal
 */
window.blockly.js.blockly.Meulocal.obterCoordenadas = function() {
 var item, meulocal;
  this.cronapi.cordova.geolocation.getCurrentPosition(function(sender_meulocal) {
      meulocal = sender_meulocal;
    this.cronapi.screen.changeValueOfField("vars.lat", this.cronapi.object.getProperty(meulocal, 'coords.latitude'));
    this.cronapi.screen.changeValueOfField("vars.long", this.cronapi.object.getProperty(meulocal, 'coords.longitude'));
  }.bind(this), function(sender_item) {
      item = sender_item;
    this.cronapi.screen.notify('error','Não foi possível obter coordenadas !!');
  }.bind(this));
}

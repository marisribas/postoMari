window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Estatisticas = window.blockly.js.blockly.Estatisticas || {};

/**
 * Estatisticas
 */
window.blockly.js.blockly.Estatisticas.popular_grafico = function() {
 var item, dados, legenda, linha, lista, serie;
  dados = this.cronapi.screen.getValueOfField('estatisticas.data');
  legenda = [];
  serie = [];
  for (var linha_index in dados) {
    linha = dados[linha_index];
    legenda.push(this.cronapi.object.getObjectField(linha, 'posto_posto'));
    serie.push(this.cronapi.object.getObjectField(linha, 'valor'));
  }
  this.cronapi.chart.createChart("chart-custokm", 'bar', legenda, null, this.cronapi.chart.createDataset('Ticket Médio', serie, null));
}

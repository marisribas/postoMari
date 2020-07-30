package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Estatisticas {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// Estatisticas
public static Var custoMedioKm() throws Exception {
 return new Callable<Var>() {

   private Var listaRet = Var.VAR_NULL;
   private Var dados = Var.VAR_NULL;

   public Var call() throws Exception {
    listaRet = cronapi.list.Operations.newList();
    dados = cronapi.database.Operations.query(Var.valueOf("app.entity.Abastecimento"),Var.valueOf("select a.carro.marca, a.carro.modelo, SUM(a.valor)/SUM(a.km) from Abastecimento a  group by a.carro.marca, a.carro.modelo"));
    while (cronapi.database.Operations.hasElement(dados).getObjectAsBoolean()) {
        cronapi.list.Operations.addLast(listaRet,cronapi.map.Operations.createObjectMapWith(Var.valueOf("marca",cronapi.database.Operations.getField(dados, Var.valueOf("this[0]"))) , Var.valueOf("modelo",cronapi.database.Operations.getField(dados, Var.valueOf("this[1]"))) , Var.valueOf("customedio",cronapi.conversion.Operations.formatDouble(cronapi.database.Operations.getField(dados, Var.valueOf("this[2]")), Var.valueOf("0.00")))));
        cronapi.database.Operations.next(dados);
    } // end while
    System.out.println(listaRet.getObjectAsString());
    return listaRet;
   }
 }.call();
}

}


package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class Login {

public static final int TIMEOUT = 300;

/**
 *
 * @param nome
 * @param email
 * @param teste
 * @return Var
 */
// Login
public static Var cadastrarUsuario(Var nome, Var email, Var teste) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    if (Var.valueOf(cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.vSenha")).equals(cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.vConfirmaSenha")))).getObjectAsBoolean()) {
        cronapi.database.Operations.insert(Var.valueOf("app.entity.User"),Var.valueOf("password",cronapi.util.Operations.encryptPassword(cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.vSenha")))),Var.valueOf("normalizedUserName",email),Var.valueOf("name",nome),Var.valueOf("normalizedEmail",email),Var.valueOf("userName",email),Var.valueOf("email",email));
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), Var.valueOf("Usuário cadastrado com sucesso !!"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideModal"), Var.valueOf("modalCadastroUser"));
    } else {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Campos senha e confirma senha não conferem !! "));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}


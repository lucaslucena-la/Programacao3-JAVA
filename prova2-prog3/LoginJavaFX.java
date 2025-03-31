import javafx.application.Application ;
import javafx.geometry.Insets ;
import javafx.scene.Scene ;
import javafx.scene.control.*;
import javafx.scene.layout.VBox ;
import javafx.stage.Stage ;

public class LoginJavaFX extends Application {

    @Override
    public void start ( Stage primaryStage ) {
        Label titleLabel = new Label ( "Login" );
        titleLabel.setStyle ( " -fx-font-size : 18 px ; -fx - font - weight : bold ; " );
        
        TextField usuarioField = new TextField ();
        usuarioField.setPromptText ( "Usuario" );
        
        PasswordField senhaField = new PasswordField ();
        senhaField.setPromptText ( "Senha" );
        
        Button loginButton = new Button ( "Entrar" );
        Label resultadoLabel = new Label ();
        resultadoLabel.setWrapText ( true );

        loginButton.setOnAction ( event -> {
            String usuario = usuarioField.getText ();
            String senha = senhaField.getText ();

            // # TODO 1: Verificar usuario e senha (usuario: admin, senha: 1234) e atualizar resultadoLabel com cor adequada

            if ( usuario . equals ("admin") && senha.equals ("1234")){
                resultadoLabel.setText ( "Bem - vindo, " + usuario + " ! ");
                resultadoLabel.setStyle ( " -fx - text - fill : green ; font - size :  14 px ; " );
            }else{
                resultadoLabel.setText ( " Usuário ou senha inválidos " );
                resultadoLabel.setStyle("-fx-text-fill: red; font-size: 14px;");
            }

        });

        // # TODO 2: Criar botao Limpar e adicionar funcionalidade para limpar os campos e resultadoLabel
        Button limparButton = new Button ("Limpar");
        limparButton.setOnAction(event -> {
            usuarioField.clear();
            senhaField.clear();
            resultadoLabel.setText("");
        });

        VBox layout = new VBox (10);
        layout.setPadding ( new Insets (20));
        layout.getChildren ().addAll (
            titleLabel, usuarioField, senhaField, loginButton, limparButton, resultadoLabel
        );

        Scene scene = new Scene( layout , 300 , 250);

        scene.getStylesheets().add(getClass().getResource( "styles.css" ).toExternalForm ());
        // # TODO 3: Garantir que os estilos definidos no CSS sejam aplicados corretamente
    
        primaryStage.setTitle ( "Sistema de Login" );
        primaryStage.setScene (scene);
        primaryStage.show ();
    }
    public static void main ( String [] args ) {
        launch(args);
    }

}



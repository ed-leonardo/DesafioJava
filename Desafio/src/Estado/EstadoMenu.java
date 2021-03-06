/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;


import Config.Config;
import java.util.Scanner;
import desafio.Desafio;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author 082170006
 */
public class EstadoMenu extends MaquinaEstado {

    @Override
    public boolean Executa() {
        boolean sair = false;
        System.out.println("*** Seja Bem-Vindo ao sistema, escolha uma das opções abaixo");
        System.out.println("0 - Sair\n1 - Ir para a tela de Cadastros");
        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();
        switch (opcao) {
            case 0:

            {
                try {
                    Config.getInstance().StopThreadAuditoria();
                     System.out.println("Aguarde o encerramento ....");
                } catch (InterruptedException ex) {
                    Logger.getLogger(EstadoMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                Desafio.estado = EnumEstadoConsole.LOGIN.getEstadoMaquina();
                break;

            case 1:
                Desafio.estado = EnumEstadoConsole.CADASTRO.getEstadoMaquina();
                break;
        }
        return sair;
    }
}

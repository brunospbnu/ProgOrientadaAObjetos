package principal;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



/*
 * Solicite o caminho de uma pasta-base e o nome de um projeto. Dentro da pasta-base, crie 
 * uma pasta com o nome do projeto. Nela, crie as subpastas dados, relatorios e backup,
 * além do arquivo vazio README.txt.
 * 
 * Informe quais itens foram criados e quais já existiam. Se parte da estrutura já estiver 
 * criada, complete os itens ausentes e preserve os existentes. Se um arquivo ocupar o 
 * caminho previsto para uma pasta, informe o conflito.
 * 
 */

public class EstruturaProjeto {

    public static void main(String[] args) {
    	
        JFileChooser seletor = new JFileChooser();
        seletor.setDialogTitle("Selecione a pasta-base:");
        seletor.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        seletor.setAcceptAllFileFilterUsed(false);

        if (seletor.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            return; // Encerra se o usuário cancelar
        }

        File pastaBase = seletor.getSelectedFile();
        if (pastaBase == null || !pastaBase.isDirectory()) {
            JOptionPane.showMessageDialog(null, "Selecione uma pasta válida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nomeProjeto = JOptionPane.showInputDialog("Informe o nome do projeto:");
        if (nomeProjeto == null || nomeProjeto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome do projeto inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        /*
         * NOTA DE ESTUDO - Por que usar StringBuilder aqui?
         * 
         * Em Java, objetos String são imutáveis. Usar "+=" dentro de laços (for/while) 
         * cria uma nova String na memória a cada repetição, descartando a anterior 
         * e gerando trabalho extra para o Garbage Collector.
         * 
         * O StringBuilder mantém um espaço mutável na memória: o método .append() 
         * apenas anexa o texto novo ao final do mesmo objeto. O texto final só é 
         * gerado uma única vez ao chamar .toString().
         */
        
        
        StringBuilder retorno = new StringBuilder();
        File pastaProjeto = new File(pastaBase, nomeProjeto.trim());

        // 1. Verifica/cria a pasta principal do projeto
        if (pastaProjeto.isFile()) {
            JOptionPane.showMessageDialog(null,
                    "CONFLITO: Já existe um arquivo com o nome '" + pastaProjeto.getName() + "' no local.",
                    "Erro de Conflito", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (pastaProjeto.isDirectory()) {
            retorno.append("Pasta do projeto '").append(pastaProjeto.getName()).append("' já existia.\n");
        } else if (pastaProjeto.mkdirs()) {
            retorno.append("Pasta do projeto '").append(pastaProjeto.getName()).append("' criada.\n");
        }

        // 2. Verifica/cria as subpastas tratando conflitos com arquivos
        String[] subpastas = {"dados", "relatorios", "backup"};
        for (String nomeSub : subpastas) {
            File sub = new File(pastaProjeto, nomeSub);
            if (sub.isFile()) {
                retorno.append("CONFLITO: Um arquivo ocupa o caminho da pasta '").append(nomeSub).append("'.\n");
            } else if (sub.isDirectory()) {
                retorno.append("A pasta '").append(nomeSub).append("' já existia.\n");
            } else if (sub.mkdir()) {
                retorno.append("Pasta '").append(nomeSub).append("' criada.\n");
            }
        }

        // 3. Verifica/cria o README.txt
        File readme = new File(pastaProjeto, "README.txt");
        if (readme.isDirectory()) {
            retorno.append("CONFLITO: Uma pasta ocupa o caminho do arquivo 'README.txt'.\n");
        } else if (readme.isFile()) {
            retorno.append("O arquivo 'README.txt' já existia.\n");
        } else {
            try {
                if (readme.createNewFile()) {
                    retorno.append("Arquivo 'README.txt' criado.\n");
                }
            } catch (IOException e) {
                retorno.append("Erro ao criar 'README.txt': ").append(e.getMessage()).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, retorno.toString(), "Resumo da Operação", JOptionPane.INFORMATION_MESSAGE);
    }
}
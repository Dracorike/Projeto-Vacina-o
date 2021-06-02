package janelas;

import javax.swing.*;

public class Main {
    public void build(){
        criarJanela();
    }


    private void criarJanela(){
        JFrame frame = new JFrame("Janela principal");
        frame.setBounds(500, 150, 700, 500);
        frame.setVisible(true);


    }

}



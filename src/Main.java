import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static ArrayList<Osoba> seznam = new ArrayList<>();
    public static JLabel[] vypisJmena = new JLabel[50];
    public static JLabel[] vypisVeku = new JLabel[50];

    public static JLabel nadpisJmena = new JLabel("Jméno");
    public static JLabel nadpisVeku = new JLabel("Věk");
    public static JLabel nadpisHledani = new JLabel("Hledané Jméno");
    public static JLabel nadpishledVek = new JLabel("Hledané Věk");

    public static JTextField vlozeneJmeno = new JTextField();
    public static JTextField vlozenyVek = new JTextField();
    public static JTextField hledaneJmeno = new JTextField();
    public static JTextField hledanyVek = new JTextField();

    public static JButton pridat = new JButton();
    public static JButton hledat = new JButton();
    public static JFrame fr = new JFrame("Okno");

    public static void main(String[] args) {

        fr.setVisible(true);
        fr.setBounds(200,200,800,500);
        fr.setLayout(null);
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        for(int i = 0; i < vypisJmena.length - 1; i++){
            JLabel zapis = new JLabel("Test");
            vypisJmena[i] = zapis;
            vypisJmena[i].setBounds(0,100 + (50 * i),100,50);
            vypisJmena[i].setVisible(true);

            JLabel zapis2 = new JLabel("TESt2");
            vypisVeku[i] = zapis;
            vypisVeku[i].setBounds(100,100 + (50 * i),100,50);
            vypisVeku[i].setVisible(true);

            fr.add(vypisJmena[i]);
            fr.add(vypisVeku[i]);
        }

        //vložení

        nadpisJmena.setBounds(10,0,100,50);
        nadpisJmena.setVisible(true);
        fr.add(nadpisJmena);
        nadpisVeku.setBounds(130,0,100,50);
        nadpisVeku.setVisible(true);
        fr.add(nadpisVeku);

        vlozeneJmeno.setBounds(10,50,100,50);
        vlozeneJmeno.setVisible(true);
        fr.add(vlozeneJmeno);
        vlozenyVek.setBounds(130,50,100,50);
        vlozenyVek.setVisible(true);
        fr.add(vlozenyVek);

        pridat.setBounds(230, 50, 50, 50);
        pridat.addActionListener(Main::PridatOsobu);
        pridat.setVisible(true);
        fr.add(pridat);

        //hledání

        nadpisHledani.setBounds(290,0,100,50);
        nadpisHledani.setVisible(true);
        fr.add(nadpisHledani);
        nadpishledVek.setBounds(410,0,100,50);
        nadpishledVek.setVisible(true);
        fr.add(nadpishledVek);

        hledaneJmeno.setBounds(290,50,100,50);
        hledaneJmeno.setVisible(true);
        fr.add(hledaneJmeno);
        hledanyVek.setBounds(410,50,100,50);
        hledanyVek.setVisible(true);
        fr.add(hledanyVek);

        hledat.setBounds(510, 50, 50, 50);
        hledat.addActionListener(Main::Filtrovat);
        hledat.setVisible(true);
        fr.add(hledat);
    }
    public static void PridatOsobu(ActionEvent e){
        String jmeno = vlozeneJmeno.getText();
        String docasnyVek = vlozenyVek.getText();
        int vek = Integer.parseInt(docasnyVek);

        Osoba obj = new Osoba();
        obj.setJmeno(jmeno);
        obj.setVek(vek);
        seznam.add(obj);

        System.out.print(seznam.get(seznam.size() -1).getJmeno());
        System.out.println(seznam.get(seznam.size() -1).getVek());

       for (int i = 0; i < seznam.size(); i++){
           JLabel docasny1 = new JLabel(seznam.get(i).getJmeno());
           vypisJmena[i] = docasny1;
           vypisJmena[i].setVisible(true);

           JLabel docasny2 = new JLabel(String.valueOf(seznam.get(i).getVek()));
           vypisVeku[i] = docasny2;
           vypisVeku[i].setVisible(true);
        }
    }

    public static void Filtrovat(ActionEvent e){

    }
}
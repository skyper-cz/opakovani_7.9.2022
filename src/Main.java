import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static String vyhledavanijmena;
    public static int vyhledavanivek;
    public static ArrayList<Osoba> seznam = new ArrayList<>();
    public static JLabel[] vypisJmena = new JLabel[999];
    public static JLabel[] vypisVeku = new JLabel[999];

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
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //vložení

        nadpisJmena.setBounds(0,0,100,50);
        nadpisJmena.setVisible(true);
        fr.add(nadpisJmena);
        nadpisVeku.setBounds(120,0,100,50);
        nadpisVeku.setVisible(true);
        fr.add(nadpisVeku);

        vlozeneJmeno.setBounds(0,50,100,50);
        vlozeneJmeno.setVisible(true);
        fr.add(vlozeneJmeno);
        vlozenyVek.setBounds(120,50,100,50);
        vlozenyVek.setVisible(true);
        fr.add(vlozenyVek);

        pridat.setBounds(230, 50, 50, 50);
        pridat.addActionListener(Main::PridatOsobu);
        pridat.setVisible(true);
        fr.add(pridat);

        //hledání

        nadpisHledani.setBounds(280,0,100,50);
        nadpisHledani.setVisible(true);
        fr.add(nadpisHledani);
        nadpishledVek.setBounds(400,0,100,50);
        nadpishledVek.setVisible(true);
        fr.add(nadpishledVek);

        hledaneJmeno.setBounds(280,50,100,50);
        hledaneJmeno.setVisible(true);
        fr.add(hledaneJmeno);
        hledanyVek.setBounds(400,50,100,50);
        hledanyVek.setVisible(true);
        fr.add(hledanyVek);

        hledat.setBounds(500, 50, 50, 50);
        hledat.addActionListener(Main::PridatOsobu);
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

        System.out.println(seznam);

       for (int i = 0; i < seznam.size(); i++){
           JLabel docasny1 = new JLabel(seznam.get(i).getJmeno());
           vypisJmena[i] = docasny1;
           vypisJmena[i].setBounds(0,100 + (100 * i),100,50);
           vypisJmena[i].setVisible(true);
           fr.add(vypisJmena[i]);

           JLabel docasny2 = new JLabel(String.valueOf(seznam.get(i).getVek()));
           vypisVeku[i] = docasny2;
           vypisVeku[i].setBounds(100,100 + (100 * i),100,50);
           vypisVeku[i].setVisible(true);
           fr.add(vypisVeku[i]);
        }
    }
}
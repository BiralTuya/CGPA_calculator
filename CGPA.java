import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Vector;

/**
 * Created by sanzi on 9/4/2016.
 */
public class CGPA extends JFrame {
    JButton calculate,oktheory,oklab;
    JLabel label,addthory,addlab,tuya;
    JSpinner theory,lab;
    JComboBox[] cmtheory=new JComboBox[20];
    JComboBox[] cmlab=new JComboBox[20];
    public CGPA(){
        getContentPane().setBackground(Color.BLACK);
        ImageIcon img= new ImageIcon("D:\\Study\\codes\\java\\cgpa\\Calculator Icon.png");
        this.setIconImage(img.getImage());

        addthory = new JLabel("Number of Theory(3 cr.)");
        addthory.setFont(new Font("Courier New", Font.BOLD, 14));
        addthory.setForeground(Color.MAGENTA);
        addthory.setBounds(20,40,200,30);
        this.add(addthory);

        SpinnerModel sm = new SpinnerNumberModel(3, 3, 20, 1);
        theory = new JSpinner(sm);
        theory.setBounds(210,40,50,30);
        this.add(theory);

        oktheory = new JButton("OK!");
        oktheory.setBounds(270,40,100,30);
        oktheory.setBackground(Color.DARK_GRAY);
        oktheory.setForeground(Color.MAGENTA);
        this.add(oktheory);

        SpinnerModel sm1 = new SpinnerNumberModel(1, 1, 10, 1);
        lab= new JSpinner(sm1);
        lab.setBounds(585,40,50,30);
        this.add(lab);

        addlab= new JLabel("Number of Lab(1 cr.)");
        addlab.setFont(new Font("Courier New", Font.BOLD, 14));
        addlab.setForeground(Color.MAGENTA);
        addlab.setBounds(420,40,200,30);
        this.add(addlab);

        oklab = new JButton("OK!");
        oklab.setBounds(640,40,100,30);
        oklab.setBackground(Color.DARK_GRAY);
        oklab.setForeground(Color.MAGENTA);
        this.add(oklab);

        calculate = new JButton("Calculate CGPA");
        calculate.setBounds(20,450,750,40);
        calculate.setBackground(Color.DARK_GRAY);
        calculate.setForeground(Color.MAGENTA);
        this.add(calculate);

        oktheory.addActionListener(e -> {
            String[] theoryst={"A+","A","A-","B+","B","B-","C+","C","C-","D+","D","D-"};
            int value= (Integer) theory.getValue();
            //System.out.println(value);
            int i,a=20,b=80,c=200,d=30;
            for(i=0;i<value;i++){
                cmtheory[i]= new JComboBox(theoryst);
                cmtheory[i].setBounds(a,b+20,c,d);
                cmtheory[i].setBackground(Color.darkGray);
                cmtheory[i].setForeground(Color.MAGENTA);
                b+=40;
                if(b>=440) JOptionPane.showMessageDialog(this, "Too many subjects!!!");
                else this.add(cmtheory[i]);
                cmtheory[i].addItem(theoryst);
            }
        });

        oklab.addActionListener(e -> {
            String[] labst={"A+","A","A-","B+","B","B-","C+","C","C-","D+","D","D-"};
            int value1= (Integer) lab.getValue();
            //System.out.println(value1);
            int i,a=420,b=80,c=200,d=30;
            for(i=0;i<value1;i++){
                cmlab[i]= new JComboBox(labst);
                cmlab[i].setBounds(a,b+20,c,d);
                cmlab[i].setBackground(Color.DARK_GRAY);
                cmlab[i].setForeground(Color.MAGENTA);
                b+=40;
                if(b>=440) JOptionPane.showMessageDialog(this, "Too many subjects!!!");
                else this.add(cmlab[i]);
                cmlab[i].addItem(labst);
            }
        });


        calculate.addActionListener(e -> {
            int getvalue= (Integer) theory.getValue();
            int getvalue1=(Integer) lab.getValue();
            int i;
            double thvlu=0,labvlu=0;
            for(i=0;i<getvalue;i++){
                if(cmtheory[i].getSelectedItem().toString()=="A+") thvlu+=4.00;
                if(cmtheory[i].getSelectedItem().toString()=="A") thvlu+=3.75;
                if(cmtheory[i].getSelectedItem().toString()=="A-") thvlu+=3.50;
                if(cmtheory[i].getSelectedItem().toString()=="B+") thvlu+=3.25;
                if(cmtheory[i].getSelectedItem().toString()=="B") thvlu+=3.00;
                if(cmtheory[i].getSelectedItem().toString()=="B-") thvlu+=2.75;
                if(cmtheory[i].getSelectedItem().toString()=="C+") thvlu+=2.50;
                if(cmtheory[i].getSelectedItem().toString()=="C") thvlu+=2.25;
                if(cmtheory[i].getSelectedItem().toString()=="C-") thvlu+=2.00;
                if(cmtheory[i].getSelectedItem().toString()=="D+") thvlu+=1.75;
                if(cmtheory[i].getSelectedItem().toString()=="D") thvlu+=1.50;
                if(cmtheory[i].getSelectedItem().toString()=="D-") thvlu+=1.25;
                //System.out.println(thvlu);
            }
            int j;
            for(j=0;j<getvalue1;j++){
                if(cmlab[j].getSelectedItem().toString()=="A+") labvlu+=4.00;
                if(cmlab[j].getSelectedItem().toString()=="A") labvlu+=3.75;
                if(cmlab[j].getSelectedItem().toString()=="A-") labvlu+=3.50;
                if(cmlab[j].getSelectedItem().toString()=="B+") labvlu+=3.25;
                if(cmlab[j].getSelectedItem().toString()=="B") labvlu+=3.00;
                if(cmlab[j].getSelectedItem().toString()=="B-") labvlu+=2.75;
                if(cmlab[j].getSelectedItem().toString()=="C+") labvlu+=2.50;
                if(cmlab[j].getSelectedItem().toString()=="C") labvlu+=2.25;
                if(cmlab[j].getSelectedItem().toString()=="C-") labvlu+=2.00;
                if(cmlab[j].getSelectedItem().toString()=="D+") labvlu+=1.75;
                if(cmlab[j].getSelectedItem().toString()=="D") labvlu+=1.50;
                if(cmlab[j].getSelectedItem().toString()=="D-") labvlu+=1.25;
                //System.out.println(thvlu);
            }
                double cgpa = ((thvlu * 3) + labvlu) / ((getvalue * 3) + getvalue1);
                System.out.println(cgpa);
                label = new JLabel();
                label.setBounds(370, 500, 200, 30);
                label.setFont(new Font("Courier New", Font.BOLD, 20));
                label.setForeground(Color.MAGENTA);
                this.add(label);
                label.setText(String.format("%.2f", (cgpa)));
        });

        tuya = new JLabel("Created by Biral Tuya");
        tuya.setBounds(630, 530, 200, 30);
        tuya.setFont(new Font("Courier New", Font.BOLD, 10));
        tuya.setForeground(Color.MAGENTA);
        this.add(tuya);

        this.setSize(800,600);
        this.setLayout(null);
        this.setVisible(true);
        this.setTitle("CGPA Calculator");
    }
    public static void main(String[] args) {
        new CGPA();
    }
}

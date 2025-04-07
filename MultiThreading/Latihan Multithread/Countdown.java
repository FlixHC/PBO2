public class CountDown extends JFrame {
    JLabel label ;
    CountDown(String title){
        super(title);
        label = new JLabel ("Start count!");
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new Panel(), BorderLayout.CENTER);
        getContentPane().add(label);
        setSize(200,100);
        setVisible(true);
    }
    
    void startCount(){
        try {
            for (int i = 10; i > 0; i--){
                Thread.sleep(1000);
                label.setText(i + " ");
            }
                label.setText("Countdown Selesai");
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
        }
        
        label.setText(Thread.currentThread().toString());
    }
}

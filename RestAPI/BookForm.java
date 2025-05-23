import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.stream.Collectors;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookForm extends JFrame{

    private bookService bookService;
    
    private void deleteBookFromAPI() {
    int selectedRow = table.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih buku yang ingin dihapus");
        return;
    }

    long id = (long) tableModel.getValueAt(selectedRow, 0);

    try {
        URL url = new URL("http://localhost:4567/api/books/" + id);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");

        int responseCode = conn.getResponseCode();
        if (responseCode == 200 || responseCode == 204) {
            JOptionPane.showMessageDialog(this, "Buku berhasil dihapus️");
            loadDataFromAPI();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menghapus buku. Code: " + responseCode);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error:\n" + e.getMessage());
    }
}
    
    private void loadDataFromAPI(){
        try{
    URL url = new URL("http://localhost:4567/api/books");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod ("GET");
    
    BufferedReader in = new BufferedReader (new InputStreamReader (conn.getInputStream()));
    String json = in.lines().collect(Collectors.joining());
    List<Book> books = new Gson().fromJson(json, new TypeToken<List<Book>>() {}.getType());
    
    tableModel.setRowCount(0);
    
    for (Book book : books){
        Object[] row = {book.getId(), book.getTitle(), book.getAuthor()};
        tableModel.addRow(row);
    }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Gagal mengambil data:\n" + e.getMessage());
        }
    }
    
    private void addBookFromAPI(){
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        
        if  (title.isEmpty()||author.isEmpty()){
            JOptionPane.showMessageDialog(this, "Judul dan Penulis perlu diisi");
            return;
        }
        
        try{
            URL url = new URL("http://localhost:4567/api/books");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            
            String jsonBody = new Gson().toJson(new Book(0, title, author));
            try (OutputStream os = conn.getOutputStream()){
                os.write(jsonBody.getBytes());
                os.flush();
            }
            
            int responseCode = conn.getResponseCode();
            if (responseCode == 200 || responseCode == 201){
                JOptionPane.showMessageDialog(this, "Buku berhasil ditambahkan");
                titleField.setText("");
                authorField.setText("");
                loadDataFromAPI();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menambahkan buku. Code: " + responseCode);
            }
            
            } catch (Exception e){
                    JOptionPane.showMessageDialog(this, "Error:\n" + e.getMessage());
                    }
        }
    
    private void editBookFromAPI() {
    int selectedRow = table.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih buku yang ingin diedit");
        return;
    }

    long id = (long) tableModel.getValueAt(selectedRow, 0);
    String title = titleField.getText().trim();
    String author = authorField.getText().trim();

    if (title.isEmpty() || author.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Judul dan Penulis tidak boleh kosong!");
        return;
    }

    try {
        URL url = new URL("http://localhost:4567/api/books/" + id);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String jsonBody = new Gson().toJson(new Book(id, title, author));
        try (OutputStream os = conn.getOutputStream()) {
            os.write(jsonBody.getBytes());
            os.flush();
        }

        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            JOptionPane.showMessageDialog(this, "Buku berhasil diedit");
            titleField.setText("");
            authorField.setText("");
            loadDataFromAPI();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui buku. Code: " + responseCode);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error:\n" + e.getMessage());
    }
}
        
    private JTable table;
    private DefaultTableModel tableModel;
    private final String[] columnNames = {"ID", "Title", "Author"};
    private JTextField titleField;
    private JTextField authorField;
    
    
        public BookForm(){
        setTitle("Book Manager GUI");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        
        table.getSelectionModel().addListSelectionListener(event ->{
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
        String selectedName = table.getValueAt(selectedRow, 0).toString();
        String selectedPrice = table.getValueAt(selectedRow, 1).toString();
        titleField.setText(selectedName);
        authorField.setText(selectedPrice);
          }
        });
    
        JScrollPane scrollPane = new JScrollPane(table);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel controlPanel = new JPanel (new GridLayout (2,1));

        JPanel inputPanel = new  JPanel (new FlowLayout());
        titleField = new JTextField (15);
        authorField = new JTextField (15);
        inputPanel.add (new JLabel ("Title:"));
        inputPanel.add (titleField);
        inputPanel.add (new JLabel ("Author:"));
        inputPanel.add (authorField);
        
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton ("Add");    
        JButton refreshButton = new JButton("Refresh");
        JButton deleteButton = new JButton ("Delete");
        JButton editButton = new JButton ("Edit");
        
        addButton.addActionListener(e -> addBookFromAPI());
        editButton.addActionListener(e -> editBookFromAPI());
        refreshButton.addActionListener(e -> loadDataFromAPI());
        deleteButton.addActionListener (e -> deleteBookFromAPI());
        
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        buttonPanel.add(addButton);
        buttonPanel.add(refreshButton);
        
        controlPanel.add(inputPanel);
        controlPanel.add(buttonPanel);
        
        add(controlPanel, BorderLayout.SOUTH);
        
        loadDataFromAPI();
}
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            BookForm gui;
            gui = new BookForm();
            gui.setVisible(true);
        });
    }
}

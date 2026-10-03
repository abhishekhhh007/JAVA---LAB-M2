
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class LibraryBookManagement extends JFrame implements ActionListener {

    JLabel idLabel, titleLabel, authorLabel, categoryLabel;
    JTextField idField, titleField, authorField;
    JComboBox<String> categoryBox;
    JTable bookTable;
    DefaultTableModel model;

    JButton addButton, deleteButton, clearButton, exitButton;

    LibraryBookManagement() {
        setTitle("Library Book Management");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(
            BorderFactory.createTitledBorder("Enter Book Details")
        );

        idLabel = new JLabel("Book ID:");
        idField = new JTextField();

        titleLabel = new JLabel("Book Title:");
        titleField = new JTextField();

        authorLabel = new JLabel("Author:");
        authorField = new JTextField();

        categoryLabel = new JLabel("Category:");
        String[] categories = {
            "Fiction", "Science", "Technology",
            "History", "Education", "Other"
        };
        categoryBox = new JComboBox<>(categories);

        inputPanel.add(idLabel);
        inputPanel.add(idField);

        inputPanel.add(titleLabel);
        inputPanel.add(titleField);

        inputPanel.add(authorLabel);
        inputPanel.add(authorField);

        inputPanel.add(categoryLabel);
        inputPanel.add(categoryBox);

        add(inputPanel, BorderLayout.NORTH);

      
        String[] columns = {
            "Book ID", "Title", "Author", "Category"
        };

        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        bookTable = new JTable(model);
        bookTable.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION
        );

        JScrollPane scrollPane = new JScrollPane(bookTable);
        scrollPane.setBorder(
            BorderFactory.createTitledBorder("Book List")
        );

        add(scrollPane, BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel(new FlowLayout());

        addButton = new JButton("Add Book");
        deleteButton = new JButton("Delete Selected");
        clearButton = new JButton("Clear Fields");
        exitButton = new JButton("Exit");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);

        
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {

            String id = idField.getText().trim();
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();
            String category =
                (String) categoryBox.getSelectedItem();

            if (id.isEmpty() || title.isEmpty() ||
                author.isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please fill in Book ID, Title, and Author.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            
            for (int i = 0; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 0).toString().equals(id)) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Book ID already exists!",
                        "Duplicate ID",
                        JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
            }

            model.addRow(new Object[] {
                id, title, author, category
            });

            JOptionPane.showMessageDialog(
                this, "Book added successfully!"
            );

            clearFields();
        }

        else if (e.getSource() == deleteButton) {

            int selectedRow = bookTable.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please select a book to delete.",
                    "No Row Selected",
                    JOptionPane.WARNING_MESSAGE
                );
            } else {
                int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete this book?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    int modelRow =
                        bookTable.convertRowIndexToModel(selectedRow);
                    model.removeRow(modelRow);

                    JOptionPane.showMessageDialog(
                        this, "Book deleted successfully!"
                    );
                }
            }
        }

        else if (e.getSource() == clearButton) {
            clearFields();
        }

        else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    void clearFields() {
        idField.setText("");
        titleField.setText("");
        authorField.setText("");
        categoryBox.setSelectedIndex(0);
        idField.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            () -> new LibraryBookManagement()
        );
    }
}

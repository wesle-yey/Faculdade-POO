import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AppGUI extends JFrame {
    private final Biblioteca biblioteca;
    private DefaultListModel<Livro> listModel;
    private JList<Livro> list1;

    public AppGUI() {
        biblioteca = new Biblioteca();
        initComponents();
    }

    private void initComponents() {
        setTitle("Biblioteca Virtual");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Criação dos componentes
        listModel = new DefaultListModel<>();
        list1 = new JList<>(listModel);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setCellRenderer(new LivroCellRenderer()); // Customização do renderer
        JScrollPane scrollPane = new JScrollPane(list1);

        JButton adicionarButton = new JButton("Adicionar Livro");
        adicionarButton.setBackground(new Color(76, 175, 80));
        adicionarButton.setForeground(Color.WHITE);
        adicionarButton.setFocusPainted(false);
        JButton removerButton = new JButton("Remover Livro");
        removerButton.setBackground(new Color(244, 67, 54));
        removerButton.setForeground(Color.WHITE);
        removerButton.setFocusPainted(false);

        JButton emprestarButton = new JButton("Emprestar Livro");
        emprestarButton.setBackground(new Color(33, 150, 243));  // Azul
        emprestarButton.setForeground(Color.WHITE);
        emprestarButton.setFocusPainted(false);

        JButton devolverButton = new JButton("Devolver Livro");
        devolverButton.setBackground(new Color(255, 193, 7));  // Amarelo
        devolverButton.setForeground(Color.WHITE);
        devolverButton.setFocusPainted(false);


        // Configuração do painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(adicionarButton);
        buttonPanel.add(removerButton);
        buttonPanel.add(emprestarButton);
        buttonPanel.add(devolverButton);

        // Configuração do painel principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Adiciona margem
        panel.add(new JLabel("Biblioteca Virtual", SwingConstants.CENTER), BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Adicionando o painel ao frame
        add(panel);

        // Configuração do listener para o botão "Adicionar Livro"
        adicionarButton.addActionListener(e -> abrirJanelaAdicionarLivro());

        // Configuração do listener para o botão "Remover Livro"
        removerButton.addActionListener(e -> removerLivroSelecionado());

        // Listener para o botão "Emprestar Livro"
        emprestarButton.addActionListener(e -> emprestarLivroSelecionado());

// Listener para o botão "Devolver Livro"
        devolverButton.addActionListener(e -> devolverLivroSelecionado());

        // Exibir a janela
        setVisible(true);
    }

    private void abrirJanelaAdicionarLivro() {
        JFrame adicionarFrame = new JFrame("Adicionar Livro");
        adicionarFrame.setSize(300, 200);
        adicionarFrame.setLocationRelativeTo(this);

        // Criação dos componentes da janela "Adicionar Livro"
        JLabel isbnLabel = new JLabel("ISBN:");
        JTextField isbnField = new JTextField(15);

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField(15);

        JLabel autorLabel = new JLabel("Autor:");
        JTextField autorField = new JTextField(15);

        JButton salvarButton = new JButton("Salvar");

        // Configuração do painel e layout
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(isbnLabel);
        panel.add(isbnField);
        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(autorLabel);
        panel.add(autorField);
        panel.add(salvarButton);

        // Adicionando o painel ao frame
        adicionarFrame.add(panel);

        // Configuração do listener para o botão "Salvar"
        salvarButton.addActionListener(e -> {
            String isbn = isbnField.getText();
            String nome = nomeField.getText();
            String autor = autorField.getText();

            if (!isbn.isEmpty() && !nome.isEmpty() && !autor.isEmpty()) {
                Livro livro = new Livro(isbn, nome, autor, false);
                biblioteca.adicionarLivro(livro);
                atualizarListaLivros();
                adicionarFrame.dispose(); // Fechar a janela após adicionar o livro
            } else {
                JOptionPane.showMessageDialog(adicionarFrame, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Exibir a janela
        adicionarFrame.setVisible(true);
    }

    private void removerLivroSelecionado() {
        int selectedIndex = list1.getSelectedIndex();
        if (selectedIndex != -1) {
            Livro livroParaRemover = listModel.getElementAt(selectedIndex);
            biblioteca.removerLivro(livroParaRemover);
            atualizarListaLivros();
            JOptionPane.showMessageDialog(this, "Livro removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um livro para remover.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void emprestarLivroSelecionado() {
        int selectedIndex = list1.getSelectedIndex();
        if (selectedIndex != -1) {
            Livro livroParaEmprestar = listModel.getElementAt(selectedIndex);
            if (!livroParaEmprestar.isEmprestado()) {
                biblioteca.marcarComoEmprestado(livroParaEmprestar);
                atualizarListaLivros();
                JOptionPane.showMessageDialog(this, "Livro emprestado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Este livro já está emprestado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um livro para emprestar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void devolverLivroSelecionado() {
        int selectedIndex = list1.getSelectedIndex();
        if (selectedIndex != -1) {
            Livro livroParaDevolver = listModel.getElementAt(selectedIndex);
            if (livroParaDevolver.isEmprestado()) {
                biblioteca.marcarComoDevolvido(livroParaDevolver);
                atualizarListaLivros();
                JOptionPane.showMessageDialog(this, "Livro devolvido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Este livro não está marcado como emprestado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um livro para devolver.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarListaLivros() {
        listModel.clear();
        for (Livro livro : biblioteca.listarLivros()) {
            listModel.addElement(livro);
        }
    }

    // Custom Cell Renderer para a JList
    private static class LivroCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Livro livro) {
                label.setText(livro.getNome() + " - " + livro.getAutor());
                if (livro.isEmprestado()) {
                    label.setForeground(Color.RED); // Muda a cor para vermelho se o livro estiver emprestado
                } else {
                    label.setForeground(Color.BLACK); // Cor padrão para livros disponíveis
                }
            }
            if (isSelected) {
                label.setBackground(new Color(0, 123, 255));
                label.setForeground(Color.WHITE);
            } else {
                label.setBackground(Color.WHITE);
            }
            return label;
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppGUI::new);
    }
}

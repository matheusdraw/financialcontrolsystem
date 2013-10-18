package financialcontrolsystem.view;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.jidesoft.plaf.LookAndFeelFactory;
import com.jidesoft.swing.JideTabbedPane;

import financialcontrolsystem.view.action.FrameMainActions;

/**********************************************************************************
 * CLASSE QUE CRIA A JANELA PRINCIPAL
 *********************************************************************************/
public class FrameMain extends JFrame {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private FrameMainActions frameMainActions;

	private Container panelMain;
	private JideTabbedPane tabbedPaneMain;
	private JPanel panelTabOverview;
	private JPanel panelTabClients;
	private JMenuBar menuBar;
	private JMenu menuCadastre;

	/******************************************************************************
	 * CONTRUTOR. O CONSTRUTOR RECEBE COMO PARÂMETRO DE ENTRADA A INTERFACE
	 * FrameMainActions, ATRAVÉS DESSA INTERFACE QUE ESSA VIEW CONSEGUE SE
	 * COMUNICAR COM O CONTROLLER.
	 ******************************************************************************/
	public FrameMain(FrameMainActions frameMainActions) {
		this.frameMainActions = frameMainActions;
		init();
	}

	private void init() {
		
		setTitle("Sistema de controle financeiro");
		setResizable(true);								// PERMITE SE A TELA PODERÁ SER RENDERIZADA E SE PODERÁ SER MAXIMIZADA.
		setExtendedState(MAXIMIZED_BOTH);				// INICIANDO A JANELA MAXIMIZADA.
		setSize(800, 600);								// DEFININDO O TAMANHO DA JANELA CASO NÃO ESTEJA MAXIMIZADA.
		setLocationRelativeTo(null);					// DEFINE QUE A TELA FIQUE NO CENTRO CASO NÃO ESTEJA MAXIMIZADA.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// DEFINE QUA SERÁ A OPERAÇÃO PADRÃO DO BOTÃO FECHAR.
		panelMain = getContentPane();					// PEGANDO O PAINEL DA FRAME.		
		setJMenuBar(getMyMenuBar());					// DEFININDO A BARRA DE MENU.
		tabbedPaneMain = new JideTabbedPane();
		panelTabOverview = new PanelTabOverview().getPanelTabOverview();
		panelTabClients = new PanelTabClients().getPanelTabClients();
		tabbedPaneMain.addTab("Visão Geral", panelTabOverview);
		tabbedPaneMain.addTab("Clientes", panelTabClients);		
		tabbedPaneMain.setSelectedComponent(panelTabOverview);
		
		LookAndFeelFactory.installJideExtension(LookAndFeelFactory.ECLIPSE3X_STYLE);
		tabbedPaneMain.setTabShape(JideTabbedPane.SHAPE_ECLIPSE3X);
		tabbedPaneMain.setColorTheme(JideTabbedPane.COLOR_THEME_WIN2K);
		
		panelMain.add(tabbedPaneMain);
		
		addWindowListener( new WindowAdapter() {			
			@Override
			public void windowClosing(WindowEvent e) {				
				int result = JOptionPane.showConfirmDialog(null, "Deseja encerrar o sistema?", "Sistema de controle financeiro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					dispose();
				} else if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}			
		});
		
	}

	/******************************************************************************
	 * BARRA DE MENU
	 ******************************************************************************/
	private JMenuBar getMyMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();

			menuBar.add(getMenuCadastre());
		}
		return menuBar;
	}

	/******************************************************************************
	 * MENUS
	 ******************************************************************************/
	private JMenu getMenuCadastre() {
		if (menuCadastre == null) {
			menuCadastre = new JMenu("Opções");

			menuCadastre.add(new MenuAccount().getMenuAccount());
		}
		return menuCadastre;
	}
}

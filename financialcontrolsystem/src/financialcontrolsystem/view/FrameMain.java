package financialcontrolsystem.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.jidesoft.plaf.LookAndFeelFactory;
import com.jidesoft.swing.JideTabbedPane;

import financialcontrolsystem.view.action.FrameMainActions;

/**********************************************************************************
 * CLASSE QUE CRIA A JANELA PRINCIPAL
 *********************************************************************************/
public class FrameMain extends JFrame {

	private static final long serialVersionUID = 1L;

	private FrameMainActions frameMainActions;

	private Container panelMain;
	private JideTabbedPane tabbedPaneMain;
	
	private PanelTabOverview panelTabOverview;
	private PanelTabClients panelTabClients;

	private JMenuBar menuBar;
	private JMenu menuCadastre;
	private JMenu menuHelp;
	private JMenu menuCadastreClient;
	
	private JMenuItem itemNewCadastreClient;
	private JMenuItem itemEditCadastreClient;
	private JMenuItem itemRemoveCadastreClient;
	private JMenuItem itemListCadastreClient;
	private JMenuItem itemExit;

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
		
		setTitle("Sistema");
		setResizable(true);								// PERMITE SE A TELA PODERÁ SER RENDERIZADA E SE PODERÁ SER MAXIMIZADA.
		setExtendedState(MAXIMIZED_BOTH);				// INICIANDO A JANELA MAXIMIZADA.
		setSize(800, 600);								// DEFININDO O TAMANHO DA JANELA CASO NÃO ESTEJA MAXIMIZADA.
		setLocationRelativeTo(null);					// DEFINE QUE A TELA FIQUE NO CENTRO CASO NÃO ESTEJA MAXIMIZADA.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// DEFINE QUA SERÁ A OPERAÇÃO PADRÃO DO BOTÃO FECHAR.
		
		panelMain = getContentPane();					// PEGANDO O PAINEL DA FRAME.		
		setJMenuBar(getMyMenuBar());					// DEFININDO A BARRA DE MENU.
		
		tabbedPaneMain = new JideTabbedPane();
		panelTabOverview = new PanelTabOverview();
		panelTabClients = new PanelTabClients();
		
		tabbedPaneMain.addTab("Visão Geral", panelTabOverview.getPanelTabOverview());
		tabbedPaneMain.addTab("Clientes", panelTabClients.getPanelTabClients());
		
		LookAndFeelFactory.installJideExtension(LookAndFeelFactory.ECLIPSE3X_STYLE);
		tabbedPaneMain.setTabShape(JideTabbedPane.SHAPE_ECLIPSE3X);
		tabbedPaneMain.setColorTheme(JideTabbedPane.COLOR_THEME_WIN2K);
		
		panelMain.add(tabbedPaneMain);
	}

	/******************************************************************************
	 * BARRA DE MENU
	 ******************************************************************************/
	private JMenuBar getMyMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();

			menuBar.add(getMenuCadastre());
			menuBar.add(getMenuAjuda());
		}
		return menuBar;
	}

	/******************************************************************************
	 * MENUS
	 ******************************************************************************/
	private JMenu getMenuCadastre() {
		if (menuCadastre == null) {
			menuCadastre = new JMenu("Cadastros");

			menuCadastre.add(getMenuClients());
		}
		return menuCadastre;
	}

	private JMenu getMenuAjuda() {
		if (menuHelp == null) {
			menuHelp = new JMenu("Ajuda");

			menuHelp.add(getItemExit());
		}
		return menuHelp;
	}

	/******************************************************************************
	 * SUBMENUS
	 ******************************************************************************/
	private JMenu getMenuClients() {
		if (menuCadastreClient == null) {
			menuCadastreClient = new JMenu("Clientes");

			menuCadastreClient.add(getItemNewCadastreClient());
			menuCadastreClient.add(getItemEditCadastreClient());
			menuCadastreClient.add(getItemRemoveCadastreClient());
			menuCadastreClient.add(getItemListCadastreClient());
		}
		return menuCadastreClient;
	}

	/******************************************************************************
	 * ITENS DO MENU
	 ******************************************************************************/
	private JMenuItem getItemNewCadastreClient() {
		if (itemNewCadastreClient == null) {
			itemNewCadastreClient = new JMenuItem("Novo");

			itemNewCadastreClient.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					tabbedPaneMain.setSelectedComponent(panelTabClients.getPanelTabClients());
				}
			});
		}
		return itemNewCadastreClient;
	}


	private JMenuItem getItemEditCadastreClient() {
		if (itemEditCadastreClient == null) {
			itemEditCadastreClient = new JMenuItem("Alterar");
		}
		return itemEditCadastreClient;
	}

	private JMenuItem getItemRemoveCadastreClient() {
		if (itemRemoveCadastreClient == null) {
			itemRemoveCadastreClient = new JMenuItem("Excluir");
		}
		return itemRemoveCadastreClient;
	}
	
	private JMenuItem getItemListCadastreClient() {
		if (itemListCadastreClient == null) {
			itemListCadastreClient = new JMenuItem("Listar");
			
			itemListCadastreClient.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {					
					// NÃO ESTÁ FAZENDO NADA.
					
				}
			});
		}
		return itemListCadastreClient;
	}

	private JMenuItem getItemExit() {
		if (itemExit == null) {
			itemExit = new JMenuItem("Sair");

			itemExit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					frameMainActions.itemExitAction();
				}
			});
		}
		return itemExit;
	}
}

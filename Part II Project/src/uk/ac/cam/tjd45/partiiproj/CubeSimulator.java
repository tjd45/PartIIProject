package uk.ac.cam.tjd45.partiiproj;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.util.concurrent.TimeUnit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class CubeSimulator {

	protected Shell shell;
	private static Cube cube;
	private static int counter = 0;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			cube = new Cube();
			CubeSimulator window = new CubeSimulator();
			window.open();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void drawFace(GC gc, int startwidth, int startdepth, int celldim, Color[] colour, byte[][] Face){
		gc.setForeground(gc.getDevice().getSystemColor(SWT.COLOR_WHITE));

		int x = startwidth;
		int y = startdepth;

		//draw face of the cube
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				Rectangle rect = new Rectangle(x, y, celldim, celldim);
				gc.setBackground(colour[Face[i][j]]);
				gc.fillRectangle(rect);
				gc.drawRectangle(rect);

				x += celldim;
				//only draw a box
			}
			x = startwidth;
			y+=celldim;
		}
	}

	private static void drawCube(Rectangle clientArea, GC gc){
		int startdepth = 10;

		int celldim = (((clientArea.height)-(startdepth*2))/12);
		int startwidth =  (int) ((int)(clientArea.width/2)-(1.5*celldim));

		Color[] colours = {gc.getDevice().getSystemColor(SWT.COLOR_RED),gc.getDevice().getSystemColor(SWT.COLOR_YELLOW),
				gc.getDevice().getSystemColor(SWT.COLOR_BLUE),gc.getDevice().getSystemColor(SWT.COLOR_GRAY),
				gc.getDevice().getSystemColor(SWT.COLOR_BLACK),gc.getDevice().getSystemColor(SWT.COLOR_GREEN)};

		gc.setForeground(gc.getDevice().getSystemColor(SWT.COLOR_WHITE));

		int x = startwidth;
		int y = startdepth;

		drawFace(gc, x, y, celldim,colours,cube.Uface);
		y += (3*celldim);
		drawFace(gc, x, y, celldim,colours,cube.Fface);
		x -= (3*celldim);
		drawFace(gc, x, y, celldim,colours,cube.Lface);
		x += (6*celldim);
		drawFace(gc, x, y, celldim,colours,cube.Rface);
		x -= (3*celldim);
		y += (3*celldim);
		drawFace(gc, x, y, celldim,colours,cube.Dface);
		y += (3*celldim);
		drawFace(gc, x, y, celldim,colours,cube.Bface);
	}
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(537, 532);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		Canvas canvas = new Canvas(composite, SWT.NONE);
		canvas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {


				GC gc = new GC(canvas);
				Rectangle rect = canvas.getClientArea();


				String alg = ""+e.character;

				cube.performAlgorithm(alg, false);
				canvas.redraw();

				if((e.character=='S')||(e.character=='s')){
					Cube cube2 = new Cube(cube);
					String solution = "";
					if(e.character=='s'){
						solution = Solutions.longsolve(cube2, "FridrichB", false);
					}else{
						solution = Solutions.longsolve(cube2, "Fridrich", false);
					}
					
					final String[] moves = solution.split("(?!^)");

					counter = 0;



					Display.getDefault().timerExec(100, new Runnable() {
						@Override
						public void run(){
							if(counter<moves.length){
								cube.performAlgorithm(moves[counter], false);
							}
							canvas.redraw();

							if(counter!=moves.length){
								counter++;
								Display.getDefault().timerExec(100, this);
							}

						}


					});








					//System.out.println(solution);

				}
				gc.dispose();

			}
		});
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {


				Rectangle clientArea = canvas.getClientArea();

				drawCube(clientArea,e.gc);



			}
		});
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		canvas.setLayout(null);
		GridData gd_canvas = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_canvas.widthHint = 526;
		gd_canvas.heightHint = 498;
		canvas.setLayoutData(gd_canvas);

	}
}

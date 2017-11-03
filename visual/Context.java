package visual;

import java.util.ArrayList;

public class Context implements IContext{
	private ArrayList<VisualCurve> curves;
	private IDrawer drawer;
	private int step;
	
	public Context(IDrawer drawer, int step) {
		curves = new ArrayList<VisualCurve>();
		this.drawer = drawer;
		this.step = step;
	}

	@Override
	public void update() {
		//drawer.clear();
		for(VisualCurve curve : curves)
			curve.Draw(drawer, step);
	}

	@Override
	public void addCurve(VisualCurve curve) {
		curves.add(curve);
	}

	@Override
	public void clearContext() {
		curves.clear();
		//drawer.clear();
	}

}

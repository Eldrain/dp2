package visual;

import java.util.ArrayList;

public class Curves {
	private ArrayList<VisualCurve> curves;
	
	public Curves() {
		curves = new ArrayList<VisualCurve>();
	}

	public void Draw(IDrawer drawer) {
		for(VisualCurve curve : curves)
			curve.Draw(drawer);
	}

	public void addCurve(VisualCurve curve) {
		curves.add(curve);
	}

	public void clear() {
		curves.clear();
	}

}

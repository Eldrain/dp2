package visual;

import geometry.ICurve;
import geometry.IPoint;

import java.util.ArrayList;

public class Group implements ICurve {
	private ArrayList<ICurve> curves;
	
	public Group() {
		curves = new ArrayList<ICurve>();
	}


	public void addCurve(ICurve curve) {
		curves.add(curve);
	}

	public void clear() {
		curves.clear();
	}

	@Override
	public IPoint getPoint(double t) {
		double step = 1/curves.size();

		for(int i = 0; i < curves.size(); i++) {
		    if(t <= (i+1) * step)
		        return curves.get(i).getPoint((t - step * i) * curves.size());
        }

		return curves.get(curves.size() - 1).getPoint(1);
	}

	@Override
	public double getLength(double t) {
		return 0;
	}

	@Override
	public double getParam(double l) {
		return 0;
	}
}

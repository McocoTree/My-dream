package publicFirstData;

public class BusInfo {
	private int nodeno;
	private double gpslati;
	private double gpslong;
	private String nodeId;
	private String nodenm;
	
	public BusInfo() {
		super();
		
	}

	public BusInfo(int nodeno, double gpslati, double gpslong, String nodeId, String nodenm) {
		super();
		this.nodeno = nodeno;
		this.gpslati = gpslati;
		this.gpslong = gpslong;
		this.nodeId = nodeId;
		this.nodenm = nodenm;
	}

	public int getNodeno() {
		return nodeno;
	}

	public void setNodeno(int nodeno) {
		this.nodeno = nodeno;
	}

	public double getGpslati() {
		return gpslati;
	}

	public void setGpslati(double gpslati) {
		this.gpslati = gpslati;
	}

	public double getGpslong() {
		return gpslong;
	}

	public void setGpslong(double gpslong) {
		this.gpslong = gpslong;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodenm() {
		return nodenm;
	}

	public void setNodenm(String nodenm) {
		this.nodenm = nodenm;
	}

	@Override
	public String toString() {
		return "BusInfo>> [" + nodeno + ", " + gpslati + ", " + gpslong + ", " + nodeId
				+ ", " + nodenm + "]";
	} 
	
	
}

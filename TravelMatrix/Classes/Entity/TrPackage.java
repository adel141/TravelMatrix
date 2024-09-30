package Classes.Entity;

public class TrPackage 
{
    private String PackageId;
    private String PackageName;
    private String PackageImgPath;
    private String PackageDetails;
    private String Transport;
    private String Hotel;
	private double price;

    public TrPackage(String PackageId,String PackageName,String PackageImgPath,String PackageDetails,String Transport,String Hotel, double  price)
    {
        this.PackageId = PackageId;
        this.PackageName = PackageName;
        this.PackageImgPath = PackageImgPath;
        this.PackageDetails = PackageDetails;
        this.Transport = Transport;
        this.Hotel = Hotel;
		this.price = price;
    }
    
    public String getPackageId() 
	{
		return PackageId;
	}

	public String getPackageName() 
	{
		return PackageName;
	}

	public String getPackageImgPath() 
	{
		return PackageImgPath;
	}


	public double  getPrice() 
	{
		return price;
	}
	public String getPackageDetails() 
	{
		return PackageDetails;
	}

	public String getTransport() 
	{
		return Transport;
	}

    public String getHotel() 
	{
		return Hotel;
	}
}

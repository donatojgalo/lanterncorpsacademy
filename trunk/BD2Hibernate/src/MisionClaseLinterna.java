
@Entity
@Table(name = "t_misionclaselinterna")
@Proxy(lazy = false)

public class MisionClaseLinterna {

	private int id;
	
	// --------------------------------------------------------------------------------

	private Mision misionRef;
	private ClaseLinterna claseLinternaRef;
	
	// --------------------------------------------------------------------------------

	public MisionClaseLinterna() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// --------------------------------------------------------------------------------


	@ManyToOne
	public Mision getMisionRef() {
		return misionRef;
	}

	public void setMisionRef(Mision misionRef) {
		this.misionRef = misionRef;
	}
	
	// --------------------------------------------------------------------------------

	
	@ManyToOne
	public ClaseLinterna getClaseLinternaRef() {
		return claseLinternaRef;
	}

	public void setClaseLinternaRef(ClaseLinterna claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}

}

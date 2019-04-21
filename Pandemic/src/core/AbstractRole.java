package core;

public abstract class AbstractRole implements IRole{
	private Role role;
	
	public AbstractRole(Role role) {
		setRole(role);
	}
	protected void setRole(Role role) {
		this.role = role;
	}
	public String getRoleName() {
		return role.getName();
	}
	public String toString() {
		return role.toString();
	}
	
	
}

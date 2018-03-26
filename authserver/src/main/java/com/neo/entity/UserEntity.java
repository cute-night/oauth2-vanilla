package com.neo.entity;

import java.io.Serializable;
import java.util.*;

import com.neo.enums.UserSexEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

public class UserEntity implements UserDetails{
    private String id;
	private String password;
	private String username;
    private UserSexEnum userSex;
    private String nickName;

	private  Set<GrantedAuthority> authorities;
	private  boolean accountNonExpired;
	private  boolean accountNonLocked;
	private  boolean credentialsNonExpired;
	private  boolean enabled;

	private Set<Resource> resources;
	private Set<Role> roles;

	public UserEntity(){
    }

	public UserEntity(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		this(username, password, true, true, true, true, authorities);
	}

	public UserEntity(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		if(username != null && !"".equals(username) && password != null) {
			this.username = username;
			this.password = password;
			this.enabled = enabled;
			this.accountNonExpired = accountNonExpired;
			this.credentialsNonExpired = credentialsNonExpired;
			this.accountNonLocked = accountNonLocked;
			this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
		} else {
			throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
		}
	}


    @Override
	public Collection<GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

    public String getId() {
        return id;
    }

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setId(String id) {
        this.id = id;
    }

    public UserSexEnum getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSexEnum userSex) {
        this.userSex = userSex;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	public void eraseCredentials() {
		this.password = null;
	}

	private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
		Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
		SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet(new UserEntity.AuthorityComparator());
		Iterator var2 = authorities.iterator();

		while(var2.hasNext()) {
			GrantedAuthority grantedAuthority = (GrantedAuthority)var2.next();
			Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
			sortedAuthorities.add(grantedAuthority);
		}

		return sortedAuthorities;
	}

	@Override
	public boolean equals(Object rhs) {
		return rhs instanceof UserEntity?this.username.equals(((UserEntity)rhs).username):false;
	}

	@Override
	public int hashCode() {
		return this.username.hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append(": ");
		sb.append("Username: ").append(this.username).append("; ");
		sb.append("Password: [PROTECTED]; ");
		sb.append("Enabled: ").append(this.enabled).append("; ");
		sb.append("AccountNonExpired: ").append(this.accountNonExpired).append("; ");
		sb.append("credentialsNonExpired: ").append(this.credentialsNonExpired).append("; ");
		sb.append("AccountNonLocked: ").append(this.accountNonLocked).append("; ");
		if(!this.authorities.isEmpty()) {
			sb.append("Granted Authorities: ");
			boolean first = true;
			Iterator var3 = this.authorities.iterator();

			while(var3.hasNext()) {
				GrantedAuthority auth = (GrantedAuthority)var3.next();
				if(!first) {
					sb.append(",");
				}

				first = false;
				sb.append(auth);
			}
		} else {
			sb.append("Not granted any authorities");
		}

		return sb.toString();
	}

	public static UserBuilder withUsername(String username) {
		return (new UserEntity.UserBuilder()).username(username);
	}

	public static class UserBuilder {
		private String username;
		private String password;
		private List<GrantedAuthority> authorities;
		private boolean accountExpired;
		private boolean accountLocked;
		private boolean credentialsExpired;
		private boolean disabled;

		private UserBuilder() {
		}

		private UserEntity.UserBuilder username(String username) {
			Assert.notNull(username, "username cannot be null");
			this.username = username;
			return this;
		}

		public UserEntity.UserBuilder password(String password) {
			Assert.notNull(password, "password cannot be null");
			this.password = password;
			return this;
		}

		public UserEntity.UserBuilder roles(String... roles) {
			List<GrantedAuthority> authorities = new ArrayList(roles.length);
			String[] var3 = roles;
			int var4 = roles.length;

			for(int var5 = 0; var5 < var4; ++var5) {
				String role = var3[var5];
				Assert.isTrue(!role.startsWith("ROLE_"), role + " cannot start with ROLE_ (it is automatically added)");
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
			}

			return this.authorities((List)authorities);
		}

		public UserEntity.UserBuilder authorities(GrantedAuthority... authorities) {
			return this.authorities(Arrays.asList(authorities));
		}

		public UserEntity.UserBuilder authorities(List<? extends GrantedAuthority> authorities) {
			this.authorities = new ArrayList(authorities);
			return this;
		}

		public UserEntity.UserBuilder authorities(String... authorities) {
			return this.authorities(AuthorityUtils.createAuthorityList(authorities));
		}

		public UserEntity.UserBuilder accountExpired(boolean accountExpired) {
			this.accountExpired = accountExpired;
			return this;
		}

		public UserEntity.UserBuilder accountLocked(boolean accountLocked) {
			this.accountLocked = accountLocked;
			return this;
		}

		public UserEntity.UserBuilder credentialsExpired(boolean credentialsExpired) {
			this.credentialsExpired = credentialsExpired;
			return this;
		}

		public UserEntity.UserBuilder disabled(boolean disabled) {
			this.disabled = disabled;
			return this;
		}

		public UserDetails build() {
			return new User(this.username, this.password, !this.disabled, !this.accountExpired, !this.credentialsExpired, !this.accountLocked, this.authorities);
		}
	}

	private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
		private static final long serialVersionUID = 420L;

		private AuthorityComparator() {
		}

		@Override
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
			return g2.getAuthority() == null?-1:(g1.getAuthority() == null?1:g1.getAuthority().compareTo(g2.getAuthority()));
		}
	}
}
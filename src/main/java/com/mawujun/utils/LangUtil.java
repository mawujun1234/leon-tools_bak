package com.mawujun.utils;

public class LangUtil {
	/**
	 * Shorthand for "if null, throw IllegalArgumentException"
	 * 
	 * @throws IllegalArgumentException "null {name}" if o is null
	 */
	public static final void throwIaxIfNull(final Object o, final String name) {
		if (null == o) {
			String message = "null " + (null == name ? "input" : name);
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * Shorthand for "if not null or not assignable, throw IllegalArgumentException"
	 * 
	 * @param c the Class to check - use null to ignore type check
	 * @throws IllegalArgumentException "null {name}" if o is null
	 */
	public static final void throwIaxIfNotAssignable(final Object ra[], final Class<?> c, final String name) {
		throwIaxIfNull(ra, name);
		String label = (null == name ? "input" : name);
		for (int i = 0; i < ra.length; i++) {
			if (null == ra[i]) {
				String m = " null " + label + "[" + i + "]";
				throw new IllegalArgumentException(m);
			} else if (null != c) {
				Class<?> actualClass = ra[i].getClass();
				if (!c.isAssignableFrom(actualClass)) {
					String message = label + " not assignable to " + c.getName();
					throw new IllegalArgumentException(message);
				}
			}
		}
	}

	/**
	 * Shorthand for "if not null or not assignable, throw IllegalArgumentException"
	 * 
	 * @throws IllegalArgumentException "null {name}" if o is null
	 */
	public static final void throwIaxIfNotAssignable(final Object o, final Class<?> c, final String name) {
		throwIaxIfNull(o, name);
		if (null != c) {
			Class<?> actualClass = o.getClass();
			if (!c.isAssignableFrom(actualClass)) {
				String message = name + " not assignable to " + c.getName();
				throw new IllegalArgumentException(message);
			}
		}
	}
	
	/**
	 * @return a String with the unqualified class name of the class (or "null")
	 */
	public static String unqualifiedClassName(Class<?> c) {
		if (null == c) {
			return "null";
		}
		String name = c.getName();
		int loc = name.lastIndexOf(".");
		if (-1 != loc) {
			name = name.substring(1 + loc);
		}
		return name;
	}

	/**
	 * @return a String with the unqualified class name of the object (or "null")
	 */
	public static String unqualifiedClassName(Object o) {
		return LangUtil.unqualifiedClassName(null == o ? null : o.getClass());
	}
}

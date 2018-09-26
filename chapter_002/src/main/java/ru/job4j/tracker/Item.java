package ru.job4j.tracker;

public class Item {
	private String id;
	private String name;
	private String desc;
	private long created;
	private String[] comments;

	/**
	 * Конструктор по умолчанию.
	 */
	public Item() {
	}
	
	/**
	 * Конструктор с параметрами.
	 * @param name - имя заявки.
	 * @param desc - описание заявки.
	 * @param created - дата создания.
	 */
	public Item(String name, String desc, long created) {
		this.name = name;
		this.desc = desc;
		this.created = created;
	}
	
	/**
	 * Метод получания id заявки.
	 * @return - id заявки
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Метод изменения id заявки.
	 * @param id - id заявки.
	 */	
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Метод получения имени заявки.
	 * @return - имя заявки.
	 */	
	public String getName() {
		return this.name;		
	}

	/**
	 * Метод изменения имени заявки.
	 * @param name - имя заявки.
	 */	
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Метод получения описания заявки.
	 * @return - описание заявки.
	 */	
	public String getDesc() {
		return this.desc;
	}

	/**
	 * Метод изменения описания заявки.
	 * @param desc - описание заявки.
	 */	
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * Метод получения времени создания заявки.
	 * @return - время создания заявки.
	 */	
	public long getCreated() {
		return this.created;
	}	

	/**
	 * Метод изменения времени создания заявки.
	 * @param created - время создания заявки.
	 */	
	public void setCreated(long created) {
		this.created = created;
	}
	
	/**
	 * Метод получения комментариев к заявке.
	 * @return - комментарии к заявке.
	 */
	public String[] getComments() {
		return this.comments;
	}
	
	/**
	 * Метод установки комментариев к заявке.
	 * @param comments - комментарии к заявке.
	 */
	public void setComments(String[] comments) {
		this.comments = comments;
	}
}
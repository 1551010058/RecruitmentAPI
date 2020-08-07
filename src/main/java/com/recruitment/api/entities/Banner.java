package com.recruitment.api.entities;

import java.util.Date;

public class Banner {
	private int BannerID;
	private String BannerName;
	private String Image;
	private String Url;
	private String Description;
	private Date StartDate;
	private Date EndDate;
	private int Position;
	private int DisplayOrder;
    private boolean IsActived;
    private Date ActivedDate;
    private String ActivedUser;
    private Date CreatedDate;
    private String CreatedUser;
    private Date UpdatedDate;
    private String UpdatedUser;
    private boolean IsDeleted;
    private Date DeletedDate;
    private String DeletedUser;
    private int TotalRecord;
	public int getBannerID() {
		return BannerID;
	}
	public void setBannerID(int bannerID) {
		BannerID = bannerID;
	}
	public String getBannerName() {
		return BannerName;
	}
	public void setBannerName(String bannerName) {
		BannerName = bannerName;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public int getPosition() {
		return Position;
	}
	public void setPosition(int position) {
		Position = position;
	}
	public int getDisplayOrder() {
		return DisplayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		DisplayOrder = displayOrder;
	}
	public boolean isIsActived() {
		return IsActived;
	}
	public void setIsActived(boolean isActived) {
		IsActived = isActived;
	}
	public Date getActivedDate() {
		return ActivedDate;
	}
	public void setActivedDate(Date activedDate) {
		ActivedDate = activedDate;
	}
	public String getActivedUser() {
		return ActivedUser;
	}
	public void setActivedUser(String activedUser) {
		ActivedUser = activedUser;
	}
	public Date getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}
	public String getCreatedUser() {
		return CreatedUser;
	}
	public void setCreatedUser(String createdUser) {
		CreatedUser = createdUser;
	}
	public Date getUpdatedDate() {
		return UpdatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		UpdatedDate = updatedDate;
	}
	public String getUpdatedUser() {
		return UpdatedUser;
	}
	public void setUpdatedUser(String updatedUser) {
		UpdatedUser = updatedUser;
	}
	public boolean isIsDeleted() {
		return IsDeleted;
	}
	public void setIsDeleted(boolean isDeleted) {
		IsDeleted = isDeleted;
	}
	public Date getDeletedDate() {
		return DeletedDate;
	}
	public void setDeletedDate(Date deletedDate) {
		DeletedDate = deletedDate;
	}
	public String getDeletedUser() {
		return DeletedUser;
	}
	public void setDeletedUser(String deletedUser) {
		DeletedUser = deletedUser;
	}
	public int getTotalRecord() {
		return TotalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		TotalRecord = totalRecord;
	}
    
    
}

package com.example.demo.service.dto;

import lombok.Data;

//AQUI CREAMOS LA CLASE JAVA CON LA QUE NOS VA A SALIR LA TBALA TRAS EL JOIN 
@Data
public class UserDocumentDTO {
    private Long userId;
    private String comment;
    private String userName;
    private Long docId;
    private String docContent;

    // Generamos los constructores vaios y llenos, porque Lombok no es de fiar
    public UserDocumentDTO() {
    }

    public UserDocumentDTO(Long userId, String comment, String userName, Long docId, String docContent) {
        this.userId = userId;
        this.comment = comment;
        this.userName = userName;
        this.docId = docId;
        this.docContent = docContent;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getDocContent() {
        return docContent;
    }

    public void setDocContent(String docContent) {
        this.docContent = docContent;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserDocumentDTO other = (UserDocumentDTO) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }


}

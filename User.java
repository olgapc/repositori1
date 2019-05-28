/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videosproject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author olga
 */
public class User
{

    private String surname;
    private String name;
    private String password;
    private LocalDateTime registrationDate;
    private UUID idUser;
    private String mail;
    private List<Video> videoList;

    public User(String surname, String name, String mail, String password)
    {

        this.surname = surname;
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.registrationDate = LocalDateTime.now();
        this.idUser = UUID.randomUUID();
        this.videoList = new ArrayList<Video>();
    }

    public String getSurname()
    {
        return surname;
    }

    public String getName()
    {
        return name;
    }

    public String getMail()
    {
        return mail;
    }

    public List<Video> getVideoList()
    {
        return videoList;
    }

    public String getPassword()
    {
        return password;
    }

    public LocalDateTime getRegistrationDate()
    {
        return registrationDate;
    }

    public UUID getIdUser()
    {
        return idUser;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setIdUser(UUID idUser)
    {
        this.idUser = idUser;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public void setVideoList(Video video)
    {
        this.videoList.add(video);
    }

}

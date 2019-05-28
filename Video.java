/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videosproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author olga
 */
public class Video
{

    String videoUrl;
    String title;
    List<String> tagList;

    public Video(String videoUrl, String title, ArrayList tags)
    {
        this.videoUrl = videoUrl;
        this.title = title;
        tagList = new ArrayList<String>();
        this.tagList = tags;
    }

    public void setVideoUrl(String videoUrl)
    {
        this.videoUrl = videoUrl;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setTags(String tag)
    {
        this.tagList.add(tag);
    }

    public String getVideoUrl()
    {
        return videoUrl;
    }

    public String getTitle()
    {
        return title;
    }

    public List getTags()
    {
        return tagList;
    }

}

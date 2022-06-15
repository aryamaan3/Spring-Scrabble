package data;

import java.util.ArrayList;

public class PlayerDetails
{
    private ArrayList<Integer> ids;
    private ArrayList<String> urls;

    public PlayerDetails()
    {}

    public PlayerDetails(ArrayList<Integer> ids, ArrayList<String> urls)
    {
        this.ids = ids;
        this.urls = urls;
    }

    public ArrayList<Integer> getIds()
    {
        return ids;
    }

    public ArrayList<String> getUrls()
    {
        return urls;
    }

    public void setIds(ArrayList<Integer> ids)
    {
        this.ids = ids;
    }

    public void setUrls(ArrayList<String> urls)
    {
        this.urls = urls;
    }

    @Override
    public String toString()
    {
        return "PlayerDetails{" +
                "ids=" + ids +
                "urls=" + urls +
                '}';
    }
}

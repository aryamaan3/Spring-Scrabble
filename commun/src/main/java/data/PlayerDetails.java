package data;

import java.util.List;

public class PlayerDetails
{
    private List<String> urls;

    public PlayerDetails()
    {}

    public PlayerDetails(List<String> urls)
    {
        this.urls = urls;
    }

    public List<String> getUrls()
    {
        return urls;
    }

    public void setUrls(List<String> urls)
    {
        this.urls = urls;
    }

    @Override
    public String toString()
    {
        return "PlayerDetails{" +
                "urls=" + urls +
                '}';
    }
}

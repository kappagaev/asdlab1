package app;

import Repositories.*;

import java.util.LinkedList;

public class App
{
    public RepositoryCollection repositories = new RepositoryCollection();

    public Router router;
    public App()
    {
        router = new Router(this);
    }
}

package StaticEntity;

import Entity.Entity;
import main.Handler;

public abstract class StaticEntity extends Entity{
	public StaticEntity(Handler handler,float x,float y,int width,int height)
	{
		super(handler,x,y,width,height);
	}
	
	protected void doOnTouch() {
	}

}

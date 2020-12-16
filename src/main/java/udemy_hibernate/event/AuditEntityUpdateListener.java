package udemy_hibernate.event;

import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;

public class AuditEntityUpdateListener implements PostUpdateEventListener {

	public AuditEntityUpdateListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean requiresPostCommitHanding(EntityPersister persister) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onPostUpdate(PostUpdateEvent event) {
		
		 System.out.println(">>>Entity updated : " + event.getEntity() );


	}

}

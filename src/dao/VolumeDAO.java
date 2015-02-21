package dao;

import javax.ejb.Stateless;
import javax.inject.Named;

import livre.Volume;
import utilisateur.User;


@Stateless
@Named
public class VolumeDAO  extends AbstractDAO<Volume>{

	public VolumeDAO() {
			super(Volume.class,"Volume");
	}
}

package br.com.prog3.aula15.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.prog3.aula15.model.Veiculo;
import br.com.prog3.aula15.util.HibernateUtil;

public class VeiculoDaoImp implements VeiculoDao {
	private Session session;

	public void incluir(Veiculo veiculo) {
		session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(veiculo);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void alterar(Veiculo veiculo) {
		session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(veiculo);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void excluir(Veiculo veiculo) {
		session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(veiculo);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Veiculo> listarTodos() {
		session = null;
		List<Veiculo> lista = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			lista = session.createQuery("from Veiculo").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			return lista;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lista;
	}

	public Veiculo buscarPelaPlaca(String placa) {
		session = null;
		Veiculo veiculo = new Veiculo();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			veiculo = (Veiculo) session.load(Veiculo.class, placa);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return veiculo;
	}
}
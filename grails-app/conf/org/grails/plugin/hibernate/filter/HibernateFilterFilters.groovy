package org.grails.plugin.hibernate.filter

class HibernateFilterFilters {

	def sessionFactory

	def filters = {
		enableHibernateFilters(controller:'*', action:'*') {
			before = {
				def session = sessionFactory.currentSession
				for (String name in DefaultHibernateFiltersHolder.defaultFilters) {
					session.enableFilter name
				}
			}
		}
	}
}

package net.jeeshop.services.front.navigation.impl;import net.jeeshop.core.ServersManager;import net.jeeshop.services.front.navigation.NavigationService;import net.jeeshop.services.front.navigation.bean.Navigation;import net.jeeshop.services.front.navigation.dao.NavigationDao;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import javax.annotation.Resource;@Servicepublic class NavigationServiceImpl extends ServersManager<Navigation, NavigationDao> implements        NavigationService {    @Resource(name = "navigationDaoFront")    @Override    public void setDao(NavigationDao navigationDao) {        this.dao = navigationDao;    }}
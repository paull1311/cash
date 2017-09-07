package edu.bionic.config;

import edu.bionic.dao.AccountDao;
import edu.bionic.dao.OperationDao;
import edu.bionic.dao.mock.AccountDaoMock;
import edu.bionic.dao.mock.OperationDaoMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"edu.bionic.service", "edu.bionic.presentation"})
public class AppConfig {

    @Bean
    public AccountDao accountDaoMock() {
        AccountDaoMock accountDaoMock = new AccountDaoMock();
        accountDaoMock.initAccountStorage();
        return accountDaoMock;
    }

    @Bean
    public OperationDao operationDaoMock() {
        OperationDaoMock operationDaoMock = new OperationDaoMock();
        operationDaoMock.initOperationStorage();
        return operationDaoMock;
    }

/*    @Bean
    public CommentDao commentDaoMock() {
        CommentDaoMock commentDaoMock = new CommentDaoMock();
        commentDaoMock.initCommentStorage();;
        return commentDaoMock;
    }*/
}

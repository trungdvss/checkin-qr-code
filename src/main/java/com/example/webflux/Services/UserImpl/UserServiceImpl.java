package com.example.webflux.Services.UserImpl;

import com.example.webflux.DataFetcher.User.AllUserDataFetcher;
import com.example.webflux.DataFetcher.User.UserDataFetcher;
import com.example.webflux.Entities.User;
import com.example.webflux.Models.BaseResponse;
import com.example.webflux.Models.UserDTO;
import com.example.webflux.Repositories.UserRepository;
import com.example.webflux.Services.UserService;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Value("classpath:graphql/Users.graphqls")
    Resource resource;
    @Autowired
    private AllUserDataFetcher allUserDataFetcher;
    @Autowired
    private UserDataFetcher userDataFetcher;
    @Autowired
    private UserRepository userRepository;

    private GraphQL graphQL;
    public GraphQL getGraphQL(){
        return graphQL;
    }
    @PostConstruct
    private void loadSchema() throws IOException {
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry,wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }
    private RuntimeWiring buildRuntimeWiring(){
        return RuntimeWiring.newRuntimeWiring()
                .type("Query",type-> type
                        .dataFetcher("allUser",allUserDataFetcher)
                        .dataFetcher("user",userDataFetcher)).build();
    }

    @Override
    public Mono<BaseResponse> createUser(UserDTO user) {
        User userEntity =new User();
        BeanUtils.copyProperties(user,userEntity);
        return userRepository.save(userEntity).map(result ->{
            if (Objects.nonNull(result.getId())){
                return BaseResponse.builder()
                        .errorCode(0)
                        .message("save data success")
                        .data(result).build();
            }else {
                return BaseResponse.builder()
                        .errorCode(1)
                        .message("save data fail")
                        .data(null).build();
            }
        });
    }
}

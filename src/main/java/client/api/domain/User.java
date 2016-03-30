package client.api.domain;

import lombok.Data;
import java.io.Serializable;

/**
 * Created by JiangZhe on 16/3/30.
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 2072925355305212835L;

    private Long id;

    private String username;
}

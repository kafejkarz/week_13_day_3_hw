package com.example.week_13_day_2_hw.components;

import com.example.week_13_day_2_hw.models.File;
import com.example.week_13_day_2_hw.models.Folder;
import com.example.week_13_day_2_hw.models.User;
import com.example.week_13_day_2_hw.repository.FileRepository;
import com.example.week_13_day_2_hw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args)  {

        User Arek = new User("Arek");
        userRepository.save(Arek);

        Folder topSecret = new Folder("topSecret",Arek);
        folderRepository.save(topSecret);

        File pine = new File("secretTree", "txt", 30, topSecret);
        fileRepository.save(pine);
    }
}

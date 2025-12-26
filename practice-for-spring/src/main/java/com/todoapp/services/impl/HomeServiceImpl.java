package com.todoapp.services.impl;

import com.todoapp.dto.DtoHome;
import com.todoapp.dto.DtoRoom;
import com.todoapp.entity.Home;
import com.todoapp.entity.Room;
import com.todoapp.repository.HomeRepository;
import com.todoapp.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public DtoHome findHomeById(Long id) {
        DtoHome dtoHome = new DtoHome();
        Optional<Home> optional = homeRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Home dbHome = optional.get();

        BeanUtils.copyProperties(dbHome,dtoHome);
        dtoHome.setRooms(new ArrayList<>());

        List<Room> dbRooms = optional.get().getRoom();
        if (dbRooms != null && !dbRooms.isEmpty()) {
            for (Room room : dbRooms) {
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(room, dtoRoom);
                dtoHome.getRooms().add(dtoRoom);
            }
        }
        return dtoHome;
    }
}
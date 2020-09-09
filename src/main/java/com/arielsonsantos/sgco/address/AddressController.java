package com.arielsonsantos.sgco.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/addresses")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping()
    public ResponseEntity<List<AddressListDTO>> findAll() {
        List<Address> addresses = service.findAll();
        List<AddressListDTO> addressListDTO = addresses.stream().map(AddressListDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(addressListDTO);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressListDTO> findById(@PathVariable Integer id) {
        AddressListDTO addressListDTO = new AddressListDTO(service.findById(id));
        return ResponseEntity.ok().body(addressListDTO);
    }

    @GetMapping(path = "/page")
    public ResponseEntity<Page<Address>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
        return ResponseEntity.ok().body(service.findPage(page, linesPerPage, orderBy, direction));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody AddressDTO addressDTO) {
        Address newAddress = service.insert(Address.fromDTO(addressDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAddress.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody AddressDTO addressDTO, @PathVariable Integer id) {
        service.update(Address.fromDTO(addressDTO), id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

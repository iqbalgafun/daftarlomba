<?php
defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH .'/libraries/Rest_Controller.php';
use Restserver\Libraries\REST_Controller;

class pendaftar extends Rest_Controller{
	
	function __construct($config='rest')
	{
		parent::__construct($config);
		//Do your magic here
		$this->load->database();
	}
	//shpw data mahasiswa
	function index_get() {
		$id = $this->get('id');
		if ($id=='') {
			# code...
			$pendaftar=$this->db->get('pendaftar')->result();
		} else {
			$this->db->where('id', $id);
			$pendaftar = $this->db->get('pendaftar')->result();
		}
		$this->response(array('result' =>$pendaftar, 200));
	}

	//insert new data
	function index_post(){
		$data = array(
			'id' => $this->post('id'),
			'nama' => $this->post('nama'),
			'alamat' => $this->post('alamat'),
			'ttl' => $this->post('ttl') );
		$insert = $this->db->insert('pendaftar', $data);
		if ($insert) {
			# code...
			$this->response(array('result' =>$data, 200));
		} else {
			$this->response(array('status' =>'fail', 502));
		}
	}

	//update data
	function index_put(){
		$id = $this->put('id');
		$data = array(
			'id' => $this->put('id'),
			'nama' => $this->put('nama'),
			'alamat' => $this->put('alamat'),
			'ttl' => $this->put('ttl'));
		$this->db->where('id', $id);
		$update = $this->db->update('pendaftar', $data);
		if($update){
			$this->response($data, 200);
		} else{
			$this->response(array('status' => 'fail', 502));
		}
	}

	//delete data
	function index_delete(){
		$id = $this->delete('id');
		$this->db->where('id', $id);
		$delete = $this->db->delete('pendaftar');
		if ($delete) {
			# code...
			$this->response(array('status' => 'success'),201);
		} else {
			$this->response(array('status' => 'fail', 502));
		}
	}
}
?>
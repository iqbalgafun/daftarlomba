<?php
defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH .'/libraries/Rest_Controller.php';
use Restserver\Libraries\REST_Controller;

class perlombaan extends Rest_Controller{
	
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
			$perlombaan=$this->db->get('perlombaan')->result();
		} else {
			$this->db->where('id', $id);
			$perlombaan = $this->db->get('perlombaan')->result();
		}
		$this->response(array('result' =>$perlombaan, 200));
	}

	//insert new data to mahasiswa
	function index_post(){
		$data = array(
			'id' => $this->post('id'),
			'nama' => $this->post('nama'),
			'cabang' => $this->post('cabang'),
			'tgl' => $this->post('tgl') );
		$insert = $this->db->insert('perlombaan', $data);
		if ($insert) {
			# code...
			$this->response(array('result' =>$data, 200));
		} else {
			$this->response(array('status' =>'fail', 502));
		}
	}

	//update data mahasiswa
	function index_put(){
		$id = $this->put('id');
		$data = array(
			'id' => $this->put('id'),
			'nama' => $this->put('nama'),
			'cabang' => $this->put('cabang'),
			'tgl' => $this->put('tgl'));
		$this->db->where('id', $id);
		$update = $this->db->update('perlombaan', $data);
		if($update){
			$this->response($data, 200);
		} else{
			$this->response(array('status' => 'fail', 502));
		}
	}

	//delete mahasiswa
	function index_delete(){
		$id = $this->delete('id');
		$this->db->where('id', $id);
		$delete = $this->db->delete('perlombaan');
		if ($delete) {
			# code...
			$this->response(array('status' => 'success'),201);
		} else {
			$this->response(array('status' => 'fail', 502));
		}
	}
}
?>
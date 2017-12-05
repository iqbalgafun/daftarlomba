<?php
defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH .'/libraries/Rest_Controller.php';
use Restserver\Libraries\REST_Controller;

class pendaftaran extends Rest_Controller{
	
	function __construct($config='rest')
	{
		parent::__construct($config);
		//Do your magic here
		$this->load->database();
	}
	//shpw data mahasiswa
	function index_get() {
		$pid = $this->get('pid');
		if ($pid=='') {
			# code...
			$pendaftaran=$this->db->get('pendaftaran')->result();
		} else {
			$this->db->where('pid', $pid);
			$pendaftaran = $this->db->get('pendaftaran')->result();
		}
		$this->response(array('result' =>$pendaftaran, 200));
	}

	//insert new data to mahasiswa
	function index_post(){
		$data = array(
			'pid' => $this->post('pid'),
			'name' => $this->post('name'),
			'email' => $this->post('email'),
			'description' => $this->post('description'));
		$insert = $this->db->insert('pendaftaran', $data);

		$this->response(array('result' =>$data, 200));

	}

	//update data mahasiswa
	function index_put(){
		$pid = $this->put('pid');
		$data = array(
			'pid' => $this->put('pid'),
			'name' => $this->put('name'),
			'email' => $this->put('email'),
			'description' => $this->put('description'));
		$this->db->where('pid', $pid);
		$update = $this->db->update('pendaftaran', $data);
		if($update){
			$this->response(array('result' =>$data, 200));
		} else{
			$this->response(array('status' => 'fail', 502));
		}
	}

	//delete mahasiswa
	function index_delete(){
		$pid = $this->delete('pid');
		$this->db->where('pid', $pid);
		$delete = $this->db->delete('pendaftaran');
		if ($delete) {
			# code...
			$this->response(array('status' => 'success'),20);
		} else {
			$this->response(array('status' => 'fail', 502));
		}
	}
}
?>